/*
 * Copyright 2024 Channelling.lk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lk.channelling.ui.controller.admin;

import lk.channelling.ui.model.PageArray;
import lk.channelling.ui.model.PagingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping()
    public ModelAndView country(Model model) {
        model.addAttribute("title", "Country Definition");
        return new ModelAndView("country");
    }

    @PostMapping("/data")
    public PageArray getData(@RequestBody PagingRequest pagingRequest) {

        restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/countries/data";
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(pagingRequest, headers);

        ResponseEntity<PageArray> response = restTemplate.postForEntity(url, entity, PageArray.class);
        return response.getBody();
    }
}
