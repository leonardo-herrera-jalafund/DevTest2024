package com.api.devtest.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    private Long id;
    private Long pollId;
    private Long optionId;
    private String voterEmail;
}
