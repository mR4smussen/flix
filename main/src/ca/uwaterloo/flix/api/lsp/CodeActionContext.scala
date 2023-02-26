/*
 * Copyright 2020 Magnus Madsen
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

import ca.uwaterloo.flix.language.ast.SourceLocation
import ca.uwaterloo.flix.util.Result
import ca.uwaterloo.flix.util.Result.{Err, Ok}
import org.json4s.JsonDSL._
import org.json4s._

/**
  * Companion object for [[CodeActionContext]].
  */
object CodeActionContext {

  /*
    * Tries to parse the given `json` value as a [[CodeActionContext]].
    */
  def parse(json: json4s.JValue): Result[CodeActionContext, String] = {

    // TODO: parse diagnostics, CodeActionKinds and CodeActionTriggerKinds
    val diagnosticsResult: Result[List[Diagnostic], String] = json \\ "diagnostics" match { ???}
    val codeActionKindResult: Result[Option[List[CodeActionKind]], String] = json \\ "only" match { ??? }
    val triggerKindResult: Result[Option[CodeActionTriggerKind], String] = json \\ "triggerKind" match { ??? }
    
    for {
      diagnostics <- diagnosticsResult
      only <- codeActionKindResult
      triggerKind <- triggerKindResult
    } yield CodeActionContext(diagnosticsResult, only, triggerKind)
  }
}
 
/**
  * Represent a `CodeActionContext` in LSP.
  *
  * @param diagnostics      An array of diagnostics known on the client side overlapping the range provided to the `textDocument/codeAction` request.
  * @param only             Actions not of this kind are filtered out by the client before being Actions.
  * @param triggerKind      The reason why code actions were requested.
  */
case class CodeActionContext(
  diagnostics: List[Diagnostic], 
  only: Option[List[CodeActionKind]], 
  triggerKind:  Option[CodeActionTriggerKind]) {
  
  def toJSON: JValue = 
    ("diagnostics" -> diagnostics) ~ 
    ("only" -> only.map(_.toString)) ~ 
    ("triggerKind" -> triggerKind.toInt)
}
