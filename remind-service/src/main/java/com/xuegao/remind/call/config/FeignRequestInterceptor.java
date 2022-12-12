package com.xuegao.remind.call.config;

import com.xuegao.util.UuidUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void apply(RequestTemplate template) {
        template.header("request-application-name", applicationName);
        template.header("traceId", UuidUtil.uuid());
        log.info("[chick-remind][FeignRequestInterceptor][apply][={}]", template.url());
        // 从header获取X-token
        // RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // ServletRequestAttributes attr = (ServletRequestAttributes) requestAttributes;
        // if (Objects.nonNull(attr)) {
        //     HttpServletRequest request = attr.getRequest();
        //     // 网关传过来的 token
        //     String token = request.getHeader("x-auth-token");
        //     if (StringUtils.hasText(token)) {
        //         template.header("X-AUTH-TOKEN", token);
        //     }
        // }
    }

}
