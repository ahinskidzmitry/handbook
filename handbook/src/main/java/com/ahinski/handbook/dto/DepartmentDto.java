package com.ahinski.handbook.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Department data transfer object
 * 
 * @author Dzmitry Ahinski
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DepartmentDto {
    
    private Long id;

    private String name;

    private String note;

    private Long parentId;

    private List<DepartmentDto> children;

    public DepartmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<DepartmentDto> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentDto> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((children == null) ? 0 : children.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DepartmentDto other = (DepartmentDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        if (children == null) {
            if (other.children != null)
                return false;
        } else if (!children.equals(other.children))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DepartmentDto [id=" + id + ", name=" + name + ", note=" + note + ", parentId=" + parentId
                + ", children=" + children + "]";
    }
}
