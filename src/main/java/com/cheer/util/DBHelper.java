package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBHelper
{
	private static final DBHelper INSTANCE = new DBHelper();

	private static final Logger LOGGER = LogManager.getLogger(DBHelper.class);

	private DBHelper()
	{

	}

	public static DBHelper getInstance()
	{
		return INSTANCE;
	}

	public Connection getConnection()
	{
		String url = null;
		String username = null;
		String password = null;

		InputStream in = null;

		try
		{
			LOGGER.info("开始读取配置文件！");

			in = DBHelper.class.getResourceAsStream("/config/db.properties");

			Properties props = new Properties();

			props.load(in);

			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");

			LOGGER.info("url={}", url);
			LOGGER.info("username={}", username);
			LOGGER.info("password={}", password);

		}
		catch(IOException e)
		{
			LOGGER.warn("未找到config/db.properties文件");
			LOGGER.catching(e);
		}
		finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch(IOException e)
				{
					LOGGER.catching(e);
				}
			}
		}

		Connection conn = null;
		try
		{
			LOGGER.info("正在加载数据库驱动...");

			Class.forName("oracle.jdbc.driver.OracleDriver");

			LOGGER.info("开始建立数据库连接...");

			conn = DriverManager.getConnection(url, username, password);
			LOGGER.info("建立数据库连接完成！");
		}
		catch(ClassNotFoundException e)
		{
			LOGGER.warn("未找到驱动类");
			LOGGER.catching(e);
		}
		catch(SQLException e)
		{
			LOGGER.catching(e);
		}
		
		return conn;
	}

	public static void closeConnection(Connection conn)
	{
		if (conn != null)
		{
			try
			{
				conn.close();
				LOGGER.info("关闭数据库连接！");
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
	}

	public static void closeStatement(Statement stat)
	{
		if (stat != null) 
		{
			try
			{
				stat.close();
				LOGGER.info("关闭声明！");
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
		
	}

	public static void closeResultSet(ResultSet rs)
	{
		if (rs != null) 
		{
			try
			{
				rs.close();
				LOGGER.info("关闭结果！");
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
	}
}