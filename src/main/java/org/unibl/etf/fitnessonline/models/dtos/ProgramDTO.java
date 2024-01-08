package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
public class ProgramDTO {
    private Integer id;
    private String name;
    private String description;
    private String location;
    private String instructor;
    private String contact;
    private Date beginDate;
    private Date endDate;
    private BigDecimal price;
    private String video;
    private String difficulty;
    private List<CommentDTO> comments;
    private List<ImageDTO> images;
    private CategorySimpleDTO category;
    private UserSimpleDTO user;
    private List<ProgramAttributeDTO> programAttributes;
}
