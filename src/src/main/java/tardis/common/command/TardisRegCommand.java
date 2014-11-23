package tardis.common.command;

import java.util.List;

import tardis.TardisMod;
import tardis.common.core.Helper;

import net.minecraft.command.ICommandSender;

public class TardisRegCommand extends TardisAbstractCommand
{

	@Override
	public String getCommandName()
	{
		return "tardisreg";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/treg <list|set|remove> <player> <dim>";
	}

	@Override
	public void addAliases(List<String> list)
	{
		list.add("treg");
	}

	@Override
	public void commandBody(ICommandSender comsen, String[] astring)
	{
		if(astring.length == 0)
			sendString(comsen,getCommandUsage(comsen));
		else
		{
			if(astring[0].equals("list"))
				TardisMod.plReg.chatMapping(comsen);
			else if(astring[0].equals("remove"))
			{
				if(astring.length == 2)
				{
					String un = astring[1];
					if(TardisMod.plReg.removePlayer(un))
						sendString(comsen,un + " removed from listing");
					else
						sendString(comsen,un + " could not be removed");
				}
			}
			else if(astring[0].equals("set"))
			{
				if(astring.length == 3)
				{
					String un = astring[1];
					int dim = Helper.toInt(astring[2], 0);
					if(TardisMod.plReg.addPlayer(un, dim))
						sendString(comsen,un + " added to listing");
					else
						sendString(comsen,un + " could not be added to listing");
				}
			}
		}
	}

}