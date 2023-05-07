package org.example.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

/**
 * JsonBodyHandler is an implementation of HttpResponse.BodyHandler that converts a response body in JSON format
 * to an object of the specified target class.
 *
 * @param <T> the type of the target class that the response body will be converted to
 */
@RequiredArgsConstructor
public class JsonBodyHandler<T> implements HttpResponse.BodyHandler<Supplier<T>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> targetClass;

    /**
     * Applies this body handler to a given HttpResponse.ResponseInfo to create a BodySubscriber that reads
     * the response body and converts it to an object of the target class.
     *
     * @param responseInfo the response info
     * @return the body subscriber that reads the response body and converts it to an object of the target class
     */
    @Override
    public HttpResponse.BodySubscriber<Supplier<T>> apply(HttpResponse.ResponseInfo responseInfo) {
        return asJSON(this.targetClass);
    }

    /**
     * Returns a BodySubscriber that reads an InputStream in JSON format and converts it to a Supplier object
     * of the specified target type.
     *
     * @param targetType the target type of the response body
     * @param <W>        the type of the target class that the response body will be converted to
     * @return a BodySubscriber that reads an InputStream in JSON format and converts it to a Supplier object
     * of the specified target type
     */
    public static <W> HttpResponse.BodySubscriber<Supplier<W>> asJSON(Class<W> targetType) {
        HttpResponse.BodySubscriber<InputStream> upstream = HttpResponse.BodySubscribers.ofInputStream();

        return HttpResponse.BodySubscribers.mapping(
                upstream,
                inputStream -> toSupplierOfType(inputStream, targetType));
    }

    /**
     * Returns a Supplier that converts the provided InputStream in JSON format to an object of the specified target class.
     *
     * @param inputStream the InputStream in JSON format
     * @param targetType  the target type of the response body
     * @param <W>         the type of the target class that the response body will be converted to
     * @return a Supplier that converts the provided InputStream in JSON format to an object of the specified target class
     */
    public static <W> Supplier<W> toSupplierOfType(InputStream inputStream, Class<W> targetType) {
        return () -> {
            try (InputStream stream = inputStream) {
                return objectMapper.readValue(stream, targetType);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        };
    }
}

