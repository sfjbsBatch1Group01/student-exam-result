//package com.data.resultprocessor;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.Base64Utils;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest({AppController.class})
//@ActiveProfiles(value = "test")
//public class ResultProcessorApplicationTests {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Value("${student.post.url}")
//    String posturl;
//
//    @Value("${student.put.url}")
//    String puturl;
//
//    @Value("${student.delete.url}")
//    String deleteurl;
//
//    @Value("${admin.user1.username}")
//    String schooladmin11;
//
//
//    @Value("${admin.user1.password}")
//    String password124;
//
//
//    @Test
//    public void testStudentPost() throws Exception {
//        Student student = createStudent("Rajiv", "a12","efg","92","82","82","54","90");
//        ResultActions responseEntity = processApiRequest(posturl, HttpMethod.POST, null, student, schooladmin1, password124);
//        responseEntity.andExpect(status().isOk());
//        ObjectMapper mapper = new ObjectMapper();
//        Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
//                new TypeReference<Employee>() {
//                });
//
//    }
//
//
//    private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Student student, String role, String SchoolName,Integer ScienceMarks, Integer MathMarks, Integer SocialScienceMarks, Integer artMarks, Integer AportMarks) {
//        ResultActions response = null;
//        String secret = "Basic " + Base64Utils.encodeToString((username+":"+password).getBytes());
//        try {
//            switch (methodType) {
//                case GET:
//                    response = mockMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
//                    break;
//                case POST:
//                    response = mockMvc.perform(post(api).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
//                            .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
//                    break;
//                case PUT:
//                    response = mockMvc.perform(put(api, name).contentType(MediaType.APPLICATION_JSON)
//                            .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
//                    break;
//                case DELETE:
//                    response = mockMvc.perform(delete(api, name));
//                    break;
//                default:
//                    fail("Method Not supported");
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail();
//        }
//        return response;
//    }
//
//    private String asJsonString(final Object obj) {
//        try {
//            final ObjectMapper mapper = new ObjectMapper();
//            final String jsonContent = mapper.writeValueAsString(obj);
//            return jsonContent;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }