/*
 * Copyright 2017 Software Engineering and Synthesis Group
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
package com.sesygroup.choreography.coordinationlogic.extractor.mock;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import com.sesygroup.choreography.abstractparticipantbehavior.model.AbstractParticipantBehavior;
import com.sesygroup.choreography.abstractparticipantbehavior.model.Message;
import com.sesygroup.choreography.abstractparticipantbehavior.model.State;
import com.sesygroup.choreography.abstractparticipantbehavior.model.Transition;
import com.sesygroup.choreography.abstractparticipantbehavior.model.action.InternalActionTransition;
import com.sesygroup.choreography.abstractparticipantbehavior.model.action.ReceiveActionTransition;
import com.sesygroup.choreography.abstractparticipantbehavior.model.action.SendActionTransition;
import com.sesygroup.choreography.abstractparticipantbehavior.model.message.InputMessage;
import com.sesygroup.choreography.abstractparticipantbehavior.model.message.OutputMessage;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class AbstractParticipantBehaviorMocks {

   public static AbstractParticipantBehavior p1() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(Arrays.asList(new State("s0"), new State("s1")));
      Set<Message> messages = new LinkedHashSet<Message>(Arrays.asList(new OutputMessage("m1")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new SendActionTransition(new State("s0"), new State("s1"), new OutputMessage("m1"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }

   public static AbstractParticipantBehavior p2() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(Arrays.asList(new State("s0"), new State("s2"), new State("s5")));
      Set<Message> messages
            = new LinkedHashSet<Message>(Arrays.asList(new OutputMessage("m2"), new OutputMessage("m5")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new SendActionTransition(new State("s0"), new State("s2"), new OutputMessage("m2")),
                  new InternalActionTransition(new State("s2"), new State("s5")),
                  new SendActionTransition(new State("s2"), new State("s5"), new OutputMessage("m5"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }

   public static AbstractParticipantBehavior p3() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(
            Arrays.asList(new State("s0"), new State("s1"), new State("s2"), new State("s5")));
      Set<Message> messages = new LinkedHashSet<Message>(Arrays.asList(new InputMessage("m1"), new InputMessage("m2"),
            new InputMessage("m5"), new OutputMessage("m6")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new ReceiveActionTransition(new State("s0"), new State("s1"), new InputMessage("m1")),
                  new ReceiveActionTransition(new State("s1"), new State("s2"), new InputMessage("m2")),
                  new ReceiveActionTransition(new State("s2"), new State("s5"), new InputMessage("m5")),
                  new InternalActionTransition(new State("s2"), new State("s5")),
                  new SendActionTransition(new State("s2"), new State("s5"), new OutputMessage("m6"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }

   public static AbstractParticipantBehavior p4() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(Arrays.asList(new State("s0"), new State("s3")));
      Set<Message> messages = new LinkedHashSet<Message>(Arrays.asList(new OutputMessage("m3")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new SendActionTransition(new State("s0"), new State("s3"), new OutputMessage("m3")),
                  new InternalActionTransition(new State("s0"), new State("s3"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }

   public static AbstractParticipantBehavior p5() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(Arrays.asList(new State("s0"), new State("s4"), new State("s5")));
      Set<Message> messages
            = new LinkedHashSet<Message>(Arrays.asList(new OutputMessage("m4"), new OutputMessage("m7")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new SendActionTransition(new State("s0"), new State("s4"), new OutputMessage("m4")),
                  new SendActionTransition(new State("s0"), new State("s5"), new OutputMessage("m7")),
                  new InternalActionTransition(new State("s0"), new State("s5")),
                  new SendActionTransition(new State("s4"), new State("s5"), new OutputMessage("m7"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }

   public static AbstractParticipantBehavior p6() {
      State initialState = new State("s0");
      Set<State> states = new LinkedHashSet<State>(
            Arrays.asList(new State("s0"), new State("s3"), new State("s4"), new State("s5")));
      Set<Message> messages = new LinkedHashSet<Message>(Arrays.asList(new InputMessage("m3"), new InputMessage("m4"),
            new InputMessage("m6"), new InputMessage("m7")));
      Set<Transition> transitions = new LinkedHashSet<Transition>(
            Arrays.asList(new ReceiveActionTransition(new State("s0"), new State("s3"), new InputMessage("m3")),
                  new ReceiveActionTransition(new State("s0"), new State("s4"), new InputMessage("m4")),
                  new InternalActionTransition(new State("s0"), new State("s5")),
                  new ReceiveActionTransition(new State("s3"), new State("s4"), new InputMessage("m6")),
                  new ReceiveActionTransition(new State("s4"), new State("s5"), new InputMessage("m7"))));

      return new AbstractParticipantBehavior(states, initialState, messages, transitions);
   }
}
