package me.lewidev.rift.events;

import lombok.Getter;
import lombok.Setter;
import me.lewidev.rift.instance.Outpost;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OutpostClaimEvent extends Event {

    @Getter
    private static final HandlerList handlers = new HandlerList();
    @Getter private final Team owner;
    @Getter private final Outpost outpost;
    @Getter @Setter
    private boolean isCancelled;

    public OutpostClaimEvent(Outpost outpost, Team owner) {
        this.outpost = outpost;
        this.owner = owner;
        this.isCancelled = false;
    }

}
