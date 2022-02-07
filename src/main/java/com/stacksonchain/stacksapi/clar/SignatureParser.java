package com.stacksonchain.stacksapi.clar;

import java.util.ArrayList;
import java.util.List;

public class SignatureParser {

  public Signature parse(String input) throws IllegalStateException {
    String name = null;
    var params = new ArrayList<String>();

    var terms = terms(input);
    var offset = 0;
    if (offset >= terms.size()) {
      throw new IllegalStateException("expected function");
    }

    if ("(".equals(terms.get(offset))) {
      if (offset + 1 >= terms.size()) {
        throw new IllegalStateException("expected function definition");
      }
      if (!"define-public".equals(terms.get(offset + 1))) {
        throw new IllegalStateException("expected define-public");
      }
      if (offset + 3 >= terms.size()) {
        throw new IllegalStateException("expected name");
      }
      name = terms.get(offset + 3);
      offset += 4;
      /* parameters */
      while (offset < terms.size()) {
        if (terms.get(offset).equals(")")) {
          offset++;
          break;
        }
        if (!(terms.get(offset).equals("(") && offset + 1 < terms.size())) {
          throw new IllegalStateException("expected parameter");
        }
        offset++;
        var param = terms.get(offset);
        params.add(param);
        offset++;
        /* type */
        offset = processType(terms, offset);
        /* ')' */
        offset += 1;
      }
    }
    if (name == null) {
      throw new IllegalStateException("cannot parse: " + input);
    }
    return new Signature(name, params);
  }

  static List<String> terms(String input) {
    var res = new ArrayList<String>();
    int offset = 0;
    while (offset < input.length()) {
      var ch = input.charAt(offset);
      switch (ch) {
        case '(' -> {
          res.add("(");
          offset++;
        }
        case ')' -> {
          res.add(")");
          offset++;
        }
        default -> {
          if(Character.isAlphabetic(ch)) {
            int end = offset;
            while (end < input.length() && termChar(input.charAt(end))) {
              end++;
            }
            res.add(input.substring(offset, end));
            offset = end;
          } else {
            /* skip char */
            offset++;
          }
        }
      }
    }
    return res;
  }

  int processType(List<String> terms, int offset) {
    int stack = 0;
    while (offset < terms.size()) {
      if ("(".equals(terms.get(offset))) {
        offset++;
        stack++;
      } else if (")".equals(terms.get(offset))) {
        offset++;
        stack--;
      } else {
        offset++;
      }
      if (stack == 0) {
        return offset;
      }

    }
    return terms.size();
  }

  static boolean termChar(char ch) {
    return Character.isLetterOrDigit(ch) ||
        ch == '-' || ch == '_';
  }

}
