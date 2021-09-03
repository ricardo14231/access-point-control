package dio.innovation.accessPointAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping()
public class SwaggerController {

    @GetMapping
    public void redirectSwagger(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "http://localhost:8080/swagger-ui/");
        httpServletResponse.setStatus(302);
    }
}
