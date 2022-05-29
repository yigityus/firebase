package com.example.firebase;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CareLedger {

    private String careLedgerId;
    private String careLedgerDefinitionId;
    private String eventId;
    private String name;
    private String description;
    private String summary;
    private String networkId;
    private String deviceReferenceId;
    private String deviceType;
    private String cabinetId;
    private String createdBy;
    private List<CareCardSpec> privateCards;
}
