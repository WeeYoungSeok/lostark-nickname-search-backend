package com.weeloa.lostark.api.service;

import com.weeloa.lostark.api.dao.SearchNames;
import com.weeloa.lostark.api.dao.dto.PossibleNamesDto;

public interface SearchNamesService {
    PossibleNamesDto getPossibleNames(SearchNames searchNames);
}
