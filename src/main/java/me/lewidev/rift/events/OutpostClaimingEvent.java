package me.lewidev.rift.events;

import lombok.Getter;
import lombok.Setter;
import me.lewidev.rift.instance.Outpost;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OutpostClaimingEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter private final Team claimingTeam;
    @Getter private final Outpost outpost;
    @Getter @Setter
    private boolean isCancelled;

    public OutpostClaimingEvent(Outpost outpost, Team claimingTeam) {
        this.outpost = outpost;
        this.claimingTeam = claimingTeam;
        this.isCancelled = false;
    }

}
