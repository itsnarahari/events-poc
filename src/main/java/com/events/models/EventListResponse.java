package com.events.models;

import java.util.ArrayList;

public class EventListResponse {
    ArrayList <EventResponse> content = new ArrayList <> ();
    Pageable PageableObject;

    public ArrayList<EventResponse> getContent() {
        return content;
    }

    public void setContent(ArrayList<EventResponse> content) {
        this.content = content;
    }

    private float totalElements;
    private float totalPages;
    private boolean last;
    private float numberOfElements;
    private float number;
    private boolean first;
    Sort SortObject;
    private float size;
    private boolean empty;


    // Getter Methods

    public Pageable getPageable() {
        return PageableObject;
    }

    public float getTotalElements() {
        return totalElements;
    }

    public float getTotalPages() {
        return totalPages;
    }

    public boolean getLast() {
        return last;
    }

    public float getNumberOfElements() {
        return numberOfElements;
    }

    public float getNumber() {
        return number;
    }

    public boolean getFirst() {
        return first;
    }

    public Sort getSort() {
        return SortObject;
    }

    public float getSize() {
        return size;
    }

    public boolean getEmpty() {
        return empty;
    }

    // Setter Methods

    public void setPageable(Pageable pageableObject) {
        this.PageableObject = pageableObject;
    }

    public void setTotalElements(float totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(float totalPages) {
        this.totalPages = totalPages;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setNumberOfElements(float numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setSort(Sort sortObject) {
        this.SortObject = sortObject;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}

class Pageable {
    Sort SortObject;
    private float pageNumber;
    private float pageSize;
    private float offset;
    private boolean paged;
    private boolean unpaged;


    // Getter Methods

    public Sort getSort() {
        return SortObject;
    }

    public float getPageNumber() {
        return pageNumber;
    }

    public float getPageSize() {
        return pageSize;
    }

    public float getOffset() {
        return offset;
    }

    public boolean getPaged() {
        return paged;
    }

    public boolean getUnpaged() {
        return unpaged;
    }

    // Setter Methods

    public void setSort(Sort sortObject) {
        this.SortObject = sortObject;
    }

    public void setPageNumber(float pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(float pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }
}
class Sort {
    private boolean sorted;
    private boolean unsorted;
    private boolean empty;


    // Getter Methods

    public boolean getSorted() {
        return sorted;
    }

    public boolean getUnsorted() {
        return unsorted;
    }

    public boolean getEmpty() {
        return empty;
    }

    // Setter Methods

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}