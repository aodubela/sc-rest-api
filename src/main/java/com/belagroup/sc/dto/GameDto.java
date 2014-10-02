package com.belagroup.sc.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Data Transfer Object used to hold game related data
 *
 * @author aodubela
 */
public class GameDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Date gameDate;

    public GameDto() {
    }

    public GameDto(Long id, String name, Date gameDate) {
        this.id = id;
        this.name = name;
        this.gameDate = gameDate;
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

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gameDate=").append(gameDate);
        sb.append('}');
        return sb.toString();
    }
}
