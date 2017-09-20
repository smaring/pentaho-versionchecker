/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2017 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.versionchecker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.RestoreSystemProperties;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bmorrise on 10/28/15.
 */
public class UUIDUtilTest {
  @Rule
  public final RestoreSystemProperties restoreSystemProperties = new RestoreSystemProperties();

  public void setUp() {
    UUIDUtil.eAddr = null;
    UUIDUtil.init();
  }

  @Test
  public void testGetUUIDAsString() {
    setUp();
    String uuid = UUIDUtil.getUUIDAsString();
    assertThat( uuid, notNullValue() );
  }

  @Test
  public void testGetUUIDWithPropertyAddress() {
    System.setProperty( "MAC_ADDRESS", "00:00:00:00:00:00" );
    setUp();
    String uuid = UUIDUtil.getUUIDAsString();
    assertThat( uuid, notNullValue() );
  }

}