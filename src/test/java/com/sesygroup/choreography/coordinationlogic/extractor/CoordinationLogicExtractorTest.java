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
package com.sesygroup.choreography.coordinationlogic.extractor;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sesygroup.choreography.abstractparticipantbehavior.model.AbstractParticipantBehavior;
import com.sesygroup.choreography.choreographyspecification.model.ChoreographySpecification;
import com.sesygroup.choreography.choreographyspecification.model.Participant;
import com.sesygroup.choreography.coordinationlogic.extractor.mock.ChoreographySpecificationMocks;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class CoordinationLogicExtractorTest {
   private static ChoreographySpecification choreographySpecification;

   @BeforeClass
   public static void setUp() {
      choreographySpecification = ChoreographySpecificationMocks.sample();
   }

   @Test
   public void testGenerator() {

      CoordinationLogicExtractor c = new CoordinationLogicExtractor(choreographySpecification);
      Map<Pair<Participant, Participant>, AbstractParticipantBehavior> cdNameToConcreteParticipantBehaviorMap
            = c.generate();

       cdNameToConcreteParticipantBehaviorMap.forEach((k, v) -> { System.out.println(k);
       System.out.println(v.getStates()); }); cdNameToConcreteParticipantBehaviorMap.forEach((k, v) -> {
       System.out.println(k); System.out.println(v.getTransitions()); });

      Assert.assertTrue(CollectionUtils.containsAll(cdNameToConcreteParticipantBehaviorMap.keySet(),
            Arrays.asList(new ImmutablePair<Participant, Participant>(new Participant("p5"), new Participant("p6")),
                  new ImmutablePair<Participant, Participant>(new Participant("p1"), new Participant("p3")),
                  new ImmutablePair<Participant, Participant>(new Participant("p2"), new Participant("p3")),
                  new ImmutablePair<Participant, Participant>(new Participant("p4"), new Participant("p6")),
                  new ImmutablePair<Participant, Participant>(new Participant("p3"), new Participant("p6")))));

      /*
       * Assert.assertTrue(CollectionUtils.containsAll(cdNameToConcreteParticipantBehaviorMap.values().stream()
       * .map(ConcreteParticipantBehavior::getStates).collect(Collectors.toList()), Arrays.asList( Arrays.asList(new
       * State("s4"), new State("s5"), new State("s2_synch"), new State("s2_branch"), new State("s4_synch"), new
       * State("s0"), new State("s1"), new State("s2_mid"), new State("s2"), new State("s3"), new State("s4_mid")),
       * Arrays.asList(new State("s4"), new State("s5"), new State("s1_synch"), new State("s0_mid"), new State("s0"),
       * new State("s1"), new State("s2"), new State("s3")), Arrays.asList(new State("s4"), new State("s5"), new
       * State("s2_synch"), new State("s2_branch"), new State("s1_synch"), new State("s1_mid"), new State("s0"), new
       * State("s1"), new State("s2_mid"), new State("s2"), new State("s3")), Arrays.asList(new State("s4"), new
       * State("s5"), new State("s3_synch"), new State("s2_synch"), new State("s2_branch"), new State("s0"), new
       * State("s1"), new State("s2_mid"), new State("s2"), new State("s3")), Arrays.asList(new State("s4"), new
       * State("s3_mid"), new State("s5"), new State("s3_synch"), new State("s4_synch"), new State("s0"), new
       * State("s1"), new State("s2"), new State("s3")) ).stream().collect(Collectors.toList())));
       */
   }

}
