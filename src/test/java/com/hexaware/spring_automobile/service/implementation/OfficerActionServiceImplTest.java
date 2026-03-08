package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.OfficerActionEntity;
import com.hexaware.spring_automobile.pojo.OfficerAction;
import com.hexaware.spring_automobile.repository.OfficerActionRepository;

@ExtendWith(MockitoExtension.class)
class OfficerActionServiceImplTest {

    @Mock
    private OfficerActionRepository actionRepository;

    @InjectMocks
    private OfficerActionServiceImpl officerActionService;

    @Test
    void testRecordAction() {

        OfficerAction action = new OfficerAction();
        action.setOldStatus("PENDING");
        action.setNewStatus("APPROVED");
        action.setComments("Verified documents");

        int result = officerActionService.recordAction(action);

        assertEquals(1, result);

        verify(actionRepository, times(1)).save(any(OfficerActionEntity.class));
    }

    @Test
    void testGetActionsByProposal() {

        OfficerActionEntity action1 = new OfficerActionEntity();
        OfficerActionEntity action2 = new OfficerActionEntity();

        when(actionRepository.getActionsByProposal(1L))
                .thenReturn(Arrays.asList(action1, action2));

        List<OfficerActionEntity> result = officerActionService.getActionsByProposal(1L);

        assertEquals(2, result.size());
    }
}