package com.example.firebase;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CareCardSpec {
    private String networkId;
    private String protocolVersion;
    private JsonNode cardDefinition;
    private JsonNode transactionData;
}
