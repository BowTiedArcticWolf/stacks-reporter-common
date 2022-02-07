package com.stacksonchain.stacksapi.clar;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Signature {
  final String name;
  final List<String> args;
}
