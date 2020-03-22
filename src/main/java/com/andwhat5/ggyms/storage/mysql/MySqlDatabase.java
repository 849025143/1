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
package com.andwhat5.ggyms.storage.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import com.andwhat5.ggyms.storage.EnumStorage;
import com.andwhat5.ggyms.storage.IStorage;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MySqlDatabase implements IStorage{
	
	private String address;
	
	private String databaseName;
	
	private String username;
	
	private String password;
	
	private int port;
	
	private HikariDataSource hikari;
	
	public MySqlDatabase(String address, String databaseName, String username, String password, int port)
	{
		this.address = address;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	
	public boolean connect() throws SQLException
	{
		try
		{
			HikariConfig config = new HikariConfig();
			config.setMaximumPoolSize(10);
			config.setPoolName("GGyms");
			config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
	        config.addDataSourceProperty("serverName", address);
	        config.addDataSourceProperty("port", port);
	        config.addDataSourceProperty("databaseName", databaseName);
	        config.addDataSourceProperty("user", username);
	        config.addDataSourceProperty("password", password);
	        
	        config.addDataSourceProperty("cachePrepStmts", true);
	        config.addDataSourceProperty("prepStmtCacheSize", 250);
	        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
	        config.addDataSourceProperty("useServerPrepStmts", true);
	        config.addDataSourceProperty("cacheCallableStmts", true);
	        config.addDataSourceProperty("alwaysSendSetIsolation", false);
	        config.addDataSourceProperty("cacheServerConfiguration", true);
	        config.addDataSourceProperty("elideSetAutoCommits", true);
	        config.addDataSourceProperty("useLocalSessionState", true);
	        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(10)); // 10000
	        config.setLeakDetectionThreshold(TimeUnit.SECONDS.toMillis(5)); // 5000
	        config.setValidationTimeout(TimeUnit.SECONDS.toMillis(3)); // 3000
	        config.setInitializationFailTimeout(1);
	        config.setConnectionTestQuery("/* GGym ping */ SELECT 1");
	        
	        this.hikari = new HikariDataSource(config);
	        return true;
		}
		catch(Exception e)
		{
			System.err.println("An unexpected error occured while attempting to access the database.");
			e.printStackTrace(System.err);
			return false;
		}
	}
	
	@Override
	public EnumStorage getTypeOfStorage() {
		return EnumStorage.MYSQL;
	}

	@Override
	public void initStorage() {
		// TODO Auto-generated method stub
		//createTables();
	}

	@Override
	public void startStorage() {
		try {
			connect();
			initStorage();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void shutdownStorage() {
		if (hikari != null) {
            hikari.close();
        }
		
	}

	@Override
	public void saveStorage() {
		
	}

	@Override
	public void reloadStorage() {
		
	}

	
    /*void createTables() {};
    
    void updateGym(String table, PixelmonGym gym)
    {
    	
    }
    
    void updateE4(String table, Elite4Gym gym)
    {
    	
    }
    
    void updatePlayer(String uuid)
    {
    	
    }
    
    
    void updateAllGyms()
    {
    	
    }
    
    void updateAllPlayers()
    {
    	
    }
    
    void updateAllE4()
    {
    	
    }
    
    public void clearTable(String table) {
        try {
            try (Connection connection = this.getConnection()) {
                if (connection == null || connection.isClosed()) {
                    throw new IllegalStateException("SQL connection is null");
                }

                try (PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE `" + table + "`")) {
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Connection getConnection() throws SQLException {
    	if(hikari == null)
    		return null;
    	else
    		return hikari.getConnection();
    }
    
    private GymData getAllGyms()
    {
    	
    }*/
}
