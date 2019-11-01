package com.amon.wfx.manager.urp.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level2Module {
    private String moduleCode;
    private String text;
    private String href;
    private Map<String,Boolean> state = new HashMap<>();
    List<Level3Module> nodes;

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Map<String, Boolean> getState() {
        return state;
    }

    public void setState(Map<String, Boolean> state) {
        this.state = state;
    }

    public List<Level3Module> getNodes() {
        return nodes;
    }

    public void setNodes(List<Level3Module> nodes) {
        this.nodes = nodes;
    }
}
