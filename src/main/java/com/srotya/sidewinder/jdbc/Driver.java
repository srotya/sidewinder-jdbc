/**
 * Copyright Ambud Sharma
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.srotya.sidewinder.jdbc;

import org.apache.calcite.avatica.DriverVersion;

public class Driver extends org.apache.calcite.avatica.remote.Driver {
	
	public static final String CONNECT_STRING_PREFIX = "jdbc:sidewinder:";
	//Connection connection = DriverManager.getConnection("jdbc:sidewinder:url=http://localhost:1099");
	static {
		new Driver().register();
	}

	@Override
	protected String getConnectStringPrefix() {
		return CONNECT_STRING_PREFIX;
	}
	
	@Override
	protected DriverVersion createDriverVersion() {
		return DriverVersion.load(
		        Driver.class,
		        "org-apache-calcite-jdbc.properties",
		        "Sidewinder Remote JDBC Driver",
		        "unknown version",
		        "Sidewinder",
		        "unknown version");
	}

}
