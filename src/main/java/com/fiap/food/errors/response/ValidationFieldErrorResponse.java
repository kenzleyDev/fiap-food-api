package com.fiap.food.errors.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationFieldErrorResponse {
    private String field;
    private String message;
    private LocalDateTime timestamp;
}
