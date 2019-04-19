package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.Labelservice;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: jiangyong
 * @date: 2018/12/4 16:54
 * @version:
 * @Copyright:
 * @modifier:
 */
@CrossOrigin
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private Labelservice labelservice;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelservice.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result fingById(@PathVariable String labelId) {
        return new Result(true, StatusCode.OK, "查询成功", labelservice.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelservice.save(label);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result updata(@PathVariable String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelservice.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId) {
        labelservice.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> list = labelservice.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageQuery = labelservice.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageQuery.getTotalElements(), pageQuery.getContent()));
    }
}
