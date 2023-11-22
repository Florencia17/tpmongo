package com.mongo.tpmongo.springbootmongo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import com.mongo.tpmongo.springbootmongo.api.PageService;
import com.mongo.tpmongo.springbootmongo.dto.AuthorPostCount;
import com.mongo.tpmongo.springbootmongo.model.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pages")
public class PageController {

    private PageService pageService ;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera una pagina en base a su id")
    public List<Page> getPageById(@PathVariable String id) {
        return this.pageService.findById(id);

    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception exception) {
        exception.printStackTrace();
    }

}
