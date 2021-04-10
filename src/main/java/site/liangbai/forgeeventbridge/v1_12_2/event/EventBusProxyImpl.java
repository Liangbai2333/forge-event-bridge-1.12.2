/*
 * Forge-Event-Bridge
 * Copyright (C) 2021  Liangbai
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package site.liangbai.forgeeventbridge.v1_12_2.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import site.liangbai.forgeeventbridge.event.EventBridge;
import site.liangbai.forgeeventbridge.event.IEventBusProxy;

public final class EventBusProxyImpl implements IEventBusProxy {
    private final EventBus eventBus;

    public EventBusProxyImpl(EventBridge.Bus bus) {
        if (bus == EventBridge.Bus.FORGE) {
            this.eventBus = MinecraftForge.EVENT_BUS;
        } else if (bus == Bus.ORE_GEN_BUS) {
            this.eventBus = MinecraftForge.ORE_GEN_BUS;
        } else if (bus == Bus.TERRAIN_GEN_BUS) {
            this.eventBus = MinecraftForge.TERRAIN_GEN_BUS;
        } else {
            this.eventBus = MinecraftForge.EVENT_BUS;
        }
    }

    @Override
    public void register(Object object) {
        eventBus.register(object);
    }

    @Override
    public void unregister(Object object) {
        eventBus.unregister(object);
    }
}
