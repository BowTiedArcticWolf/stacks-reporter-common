package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeInfo(
    use = Id.NAME,
    include = As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @Type(value = StxPostCondition.class, name = "stx"),
    @Type(value = NonFungiblePostCondition.class, name = "non_fungible"),
    @Type(value = FungiblePostCondition.class, name = "fungible"),
})
public abstract class PostCondition {

  @JsonProperty("condition_code")
  String conditionCode;
}
