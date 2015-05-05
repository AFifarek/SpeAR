# SpeAR
Specification and Analysis for Requirements Tool

SpeAR is designed to aid in the creation of requirements by encouraging the use of formally-based patterns. This methodology helps to further reduce the ambiguity found in natural language and also leverages model checking techniques to analyze initial requirement sets.

## Downloads
The latest release of SpeAR is available on the [releases page](https://github.com/AFifarek/SpeAR/releases). Currently the available release is compatible with Windows x64 bit architecture including an integrated Eclipse and XText package. In the future an integrated Linux package will also be made available.

## Installation Notes
The process of using SpeAR to enter requirements is fully included in the release package. Entry of requirements through this tool allows for pattern-based authoring with included text highlighting to aid in construction. The benefit of analysis of the requirements is achieved utilizing the Java version of the [Kind 2 model checker](http://kind2-mc.github.io/kind2/). This model checker, [JKind](https://github.com/agacek/jkind/) must be installed to conduct the necessary analysis steps. Please download and install this model checker according to its release information.
