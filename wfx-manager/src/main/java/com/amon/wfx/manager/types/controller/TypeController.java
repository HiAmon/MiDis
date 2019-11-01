package com.amon.wfx.manager.types.controller;

import com.amon.wfx.manager.types.service.impl.TypeService;
import com.amon.wfx.manager.types.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/list")
    @ResponseBody
    public List listType(){
        HashMap<String,Object> tree = new HashMap<>();
        List<TypeVO> typeVOS = typeService.listTypes();
        tree.put("text","商品信息列表");
        tree.put("nodes",typeVOS);
        List list = new ArrayList<>();
        list.add(tree);
        return list;
    }
}
