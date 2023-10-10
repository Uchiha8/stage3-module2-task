package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public class NewsDTOResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsDTOResponse() {
    }

    public NewsDTOResponse(Long id, String title, String content, LocalDateTime startDate, LocalDateTime lastUpdateDate, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "NewsDTOResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startDate=" + startDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorId=" + authorId +
                '}';
    }
}
