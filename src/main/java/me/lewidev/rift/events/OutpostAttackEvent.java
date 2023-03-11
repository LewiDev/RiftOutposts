package me.lewidev.rift.events;

import lombok.Getter;
import lombok.Setter;
import me.lewidev.rift.instance.Outpost;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OutpostAttackEvent extends Event {

    @Getter private static final HandlerList handlers = new HandlerList();
    @Getter private final Team attackingTeam;
    @Getter private final Team defendingTeam;
    @Getter private final Outpost outpost;
    @Getter @Setter private boolean isCancelled;

    public OutpostAttackEvent(Outpost outpost, Team attackingTeam, Team defendingTeam) {
        this.outpost = outpost;
        this.attackingTeam = attackingTeam;
        this.defendingTeam = defendingTeam;
        this.isCancelled = false;
    }

}
