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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {


    @GetMapping()
    public ModelAndView country(Model model) {
        model.addAttribute("title", "Country Definition");
        return new ModelAndView("country");
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Object[]> getData() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"LK", "Sri Lanka", "LK", "ACTIVE", "Chinthaka", new Date()});
        return data;
    }
}
