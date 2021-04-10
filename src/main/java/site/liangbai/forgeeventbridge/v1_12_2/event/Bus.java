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

import net.minecraftforge.common.util.EnumHelper;
import site.liangbai.forgeeventbridge.event.EventBridge;

public final class Bus {
    public static EventBridge.Bus ORE_GEN_BUS = EnumHelper
            .addEnum(EventBridge.Bus.class, "ORE_GEN_BUS", new Class[] {});

    public static EventBridge.Bus TERRAIN_GEN_BUS = EnumHelper
            .addEnum(EventBridge.Bus.class, "TERRAIN_GEN_BUS", new Class[] {});
}
