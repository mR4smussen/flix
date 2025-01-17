/*
 * Copyright 2022 Paul Butcher, Lukas Rønn
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
package ca.uwaterloo.flix.api.lsp.provider.completion

import ca.uwaterloo.flix.api.Flix
import ca.uwaterloo.flix.api.lsp.Index
import ca.uwaterloo.flix.api.lsp.provider.completion.Completion.SnippetCompletion
import ca.uwaterloo.flix.language.ast.TypedAst

object SnippetCompleter extends Completer {
  /**
    * Returns a List of Completion for snippet.
    */
  override def getCompletions(implicit context: CompletionContext, flix: Flix, index: Index, root: Option[TypedAst.Root], delta: DeltaContext): Iterable[SnippetCompletion] = {
    List(
      // NB: Please keep the list alphabetically sorted.
      ("main",
        "def main(): Unit \\ IO = \n    println(\"Hello World!\")",
        "snippet for Hello World Program"),
      ("query",
        "query ${1:db} select ${2:cols} from ${3:preds} ${4:where ${5:cond}}",
        "snippet for query")
    ) map { case (name, snippet, documentation) => Completion.SnippetCompletion(name, snippet, documentation, context)}
  }
}
