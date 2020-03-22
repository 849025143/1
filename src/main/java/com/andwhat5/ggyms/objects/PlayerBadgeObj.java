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
package com.andwhat5.ggyms.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * An object that contains all of the necessary metadata associated with defeating a gym leader.
 */
public class PlayerBadgeObj {

	/**
	 * The {@link UUID} of a corresponding {@link BadgeObj}.
	 */
	private UUID badgeUUID;
	
	/**
	 * An {@link ArrayList} of Pokémon names as a {@link String}.
	 */
	private ArrayList<String> pokemon;
	
	/**
	 * The {@link Date} this gym was defeated.
	 */
	private Date dateBeaten;
	
	/**
	 * An {@link ArrayList} of additional lore associated with this gym badge.
	 * This lore is user configurable.
	 */
	private ArrayList<String> additionalLore;
	
	public PlayerBadgeObj(UUID badgeUUID, Date dateBeaten)
	{
		this.dateBeaten = dateBeaten;
		
		this.badgeUUID = badgeUUID;
		
		this.pokemon = new ArrayList<String>();
		
		this.additionalLore = new ArrayList<String>();
	}
	
	/**
	 * This sets the {@link UUID} that is associated with the badge to something else.
	 * @param badgeUUID The {@link UUID} you would like to change the badge to.
	 */
	public void setBadgeUUID(UUID badgeUUID)
	{
		this.badgeUUID = badgeUUID;
	}
	
	/**
	 * This adds a Pokémon to the list of Pokémon used to defeat the gym leader.
	 * @param pokemon - The name of the Pokémon you wish to add.
	 */
	public void addPokemon(String pokemon)
	{
		this.pokemon.add(pokemon.toLowerCase());
	}
	
	/**
	 * This removes a Pokémon to the list of Pokémon used to defeat the gym leader.
	 * @param pokemon - The name of the Pokémon you wish to remove.
	 */
	public void removePokemon(String pokemon)
	{
		this.pokemon.remove(pokemon.toLowerCase());
	}
	
	/**
	 * This confirms if the list of Pokémon used to defeat a gym leader has your specified Pokémon. 
	 * This will return True if the Pokémon's name is found anywhere in the list, regardless of how many occurrences.
	 * @param pokemon - The name of the Pokémon you wish to confirm. This is not case sensitive. 
	 * @return True or False - The function will return true if the Pokémon passed through is found at least once and false
	 * if it is not found at least once.
	 */
	public boolean hasPokemon(String pokemon)
	{
		return this.pokemon.contains(pokemon.toLowerCase());
	}
	
	/**
	 * This method will return the date the player defeated the gym leader.
	 * @return {@link Date} - The date the player defeated the gym leader.
	 */
	public Date getDate()
	{
		return this.dateBeaten;
	}
	
	/**
	 * This method will set the {@link Date} the player defeated the gym leader.
	 * @param {@link Date} dateBeaten - The date the player defeated the gym leader.
	 */
	public void setDate(Date dateBeaten)
	{
		this.dateBeaten = dateBeaten;
	}
	
	/**
	 * This method will add user defined lore to a gym badge a player has earned.
	 * @param loreTag - The tag for the lore you are adding. This will be displayed to the left of your lore and will be used to
	 * identify your lore.
	 * @param lore - The context of the lore you wish to add.
	 */
	public void addLore(String loreTag, String lore)
	{
		this.additionalLore.add(loreTag + ": " + lore);
	}
	
	/**
	 * This method will remove user defined lore from a players badge. It accepts the tag of the lore you wish to remove.
	 * @param loreTag - The tag for the lore you are removing. This is displayed to the left of your lore.
	 */
	public void removeLore(String loreTag)
	{
		this.additionalLore.forEach(lore -> { if(lore.startsWith(loreTag)) { this.additionalLore.remove(lore); return; }});
	}
}
