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

package site.liangbai.forgeeventbridge.v1_12_2.classcreator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.ModClassLoader;
import net.minecraftforge.fml.common.eventhandler.ASMEventHandler;
import site.liangbai.forgeeventbridge.asm.classcreator.IClassCreator;
import site.liangbai.forgeeventbridge.util.Reflection;

import java.lang.reflect.Method;

public final class ASMClassCreator implements IClassCreator {
    public static final ClassLoader FORGE_CLASS_LOADER
            = getForgeClassLoader();

    @Override
    public Class<?> create(String name, byte[] classBuffer) {
        Method defineMethod = Reflection.findDeclaredMethodOrNull(ClassLoader.class, "defineClass", String.class, byte[].class, int.class, int.class);

        Class<?> clazz = Reflection.invokeMethodOrNull(
                defineMethod, FORGE_CLASS_LOADER,
                Class.class,
                name, classBuffer, 0, classBuffer.length
        );

        if (clazz == null || Reflection.findClassOrNull(name) == null) {
            throw new ClassFormatError("could not define class: " + name);
        }

        return clazz;
    }

    public static ClassLoader getForgeClassLoader() {
        ClassLoader classLoader;


        classLoader = ASMEventHandler.class.getClassLoader();

        if (!(classLoader instanceof ModClassLoader)) {
            return classLoader;
        }

        classLoader = MinecraftForge.class.getClassLoader();

        if (!(classLoader instanceof ModClassLoader)) {
            return classLoader;
        }

        classLoader = Thread.currentThread().getContextClassLoader();

        if (!(classLoader instanceof ModClassLoader)) {
            return classLoader;
        }

        return ClassLoader.getSystemClassLoader();
    }
}
