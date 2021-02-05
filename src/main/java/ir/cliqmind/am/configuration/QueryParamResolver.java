package ir.cliqmind.am.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.cliqmind.am.dto.GetActiveFeaturesRequest;
import ir.cliqmind.am.dto.GetCouponsRequest;
import ir.cliqmind.am.dto.GetCreditBalanceRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.*;
import java.util.stream.Collectors;

public class QueryParamResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;
    private final List<Class> matchedList;

    public QueryParamResolver(){
        objectMapper = new ObjectMapper();
        matchedList = Arrays.asList(
                GetCouponsRequest.class,
                GetCreditBalanceRequest.class,
                GetActiveFeaturesRequest.class);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return matchedList.contains(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        return objectMapper.readValue(
                objectMapper.writeValueAsString(
                        nativeWebRequest.getParameterMap().entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()[0])).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))),
                methodParameter.getParameterType()
        );
    }

}