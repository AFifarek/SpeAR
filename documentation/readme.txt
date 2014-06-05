NOTE: This readme is still a work in progess
===============================================================================
Specification Platform for Expression and Analysis of Requirements (SPEAR)
===============================================================================

[What spear is and what it can be used for]
Spear is an experimental software system that permits formalization and
reasoning over requirements. 

[The requirements language]
The formalization language supports two parallel
semantic analysis systems; standard type checking and unit checking (aka, 
dimension analysis). The type system supports integers, reals, and booleans as primitive types. Additionally,
enumerated types, named types, and records are permitted. A specification that
is "unit safe" is one where addition, subtraction, and equivalence operations
are only applied to like unit terms. Multiplication and division may be applied to non-like unit terms resulting in ratios and polynomial units.
The typing and unit rules are not captured anywhere concisely. They must be inferred from '../src/spear/validation/TypeChecking.java' and '../src/spear/validation/UnitChecking.java'.
The grammar for he formalization language can be found in the file '../src/spear/language/language.xtext' relative to this file.
TODO: Give a high level break down of how Spear requirement files are constructed.
TODO: Something about PLTL.
TODO: Discuss the high level semantics of the languages. 

[How requirements and properties can be used to apply model checking techniques]
The goal of formalizing requirements is to automate reasoning over properties.
Type and unit safe requirements and properties in the formalization language have a natural translation to a target language called Lustre. Lustre is a synchronous dataflow language and programs in lustre can be represented using finite state machines. Therefore, we may translate requirements and properties to finite state machines and use model checking techniques verify property validity.

[How spear does model checking now and what tools it uses]