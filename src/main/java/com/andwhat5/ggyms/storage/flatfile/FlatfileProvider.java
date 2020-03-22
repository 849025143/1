/** Copyright Notice
 * This file is part of GGyms.

 * GGyms is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, at version 3 of the license.
 *
 * GGyms is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GGyms.  If not, see <https://www.gnu.org/licenses/>.
 */

//Created by Avery Gambetti on Mar 12, 2020 12:57:08 AM 
package com.andwhat5.ggyms.storage.flatfile;

import com.andwhat5.ggyms.storage.EnumStorage;
import com.andwhat5.ggyms.storage.IStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FlatfileProvider implements IStorage{

	@Override
	public EnumStorage getTypeOfStorage() {
		// TODO Auto-generated method stub
		return EnumStorage.FLATFILE;
	}

	@Override
	public void initStorage() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
	}

	@Override
	public void startStorage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdownStorage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStorage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadStorage() {
		// TODO Auto-generated method stub
		
	}

}
