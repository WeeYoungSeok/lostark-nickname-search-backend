package com.weeloa.lostark.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Names {
    private List<String> searchNames;

    private void validation() {
        nullAndEmptyValid();
        limitLengthValidate();
    }

    private void nullAndEmptyValid() {
        if (this.searchNames == null || this.searchNames.size() <= 0) {
            throw new IllegalArgumentException("검색 가능한 닉네임이 존재하지 않습니다.");
        }
    }

    public void limitLengthValidate() {
        if (this.searchNames.size() > 100) {
            throw new IllegalArgumentException("검색 가능한 닉네임은 한번에 100개까지만 가능합니다.");
        }
    }
}
