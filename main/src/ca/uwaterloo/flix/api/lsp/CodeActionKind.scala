/*
 * Copyright 2021 Magnus Madsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.uwaterloo.flix.api.lsp

/**
  * Represents a `CodeActionKind` in LSP.
  * kinds: https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#codeActionKind
  */
sealed trait CodeActionKind {
  def toString: String = this match {
    case CodeActionKind.Empty => ""
    case CodeActionKind.Method => "quickfix"
    case CodeActionKind.Refactor => "refactor"
    case CodeActionKind.RefactorExtract => "refactor.extract"
    case CodeActionKind.RefactorInline => "refactor.inline"
    case CodeActionKind.RefactorRewrite => "refactor.rewrite"
    case CodeActionKind.Source => "refactor.rewrite"
    case CodeActionKind.SourceOrganizeImports => "source.organizeImports"
    case CodeActionKind.SourceFixAll => "source.fixAll"
  }
}

object CodeActionKind {
  case object Empty extends CodeActionKind

  case object Method extends CodeActionKind

  case object Refactor extends CodeActionKind

  case object RefactorExtract extends CodeActionKind

  case object RefactorInline extends CodeActionKind

  case object RefactorRewrite extends CodeActionKind

  case object Source extends CodeActionKind

  case object SourceOrganizeImports extends CodeActionKind

  case object SourceFixAll extends CodeActionKind

}
