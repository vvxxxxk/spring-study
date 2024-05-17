package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // content-type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // 객체 생성 및 초기화
        HelloData helloData = new HelloData();
        helloData.setUsername("유저");
        helloData.setAge(30);

        // 객체를 기반해서 JSON 생성
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
