package com.cosmicnet.effectivej.item33;

import java.util.Map;
import java.util.Objects;
import java.util.HashMap;


public class Favorite {
	
	private Map<Class<?>, Object> favorites = new HashMap<>();
	
	public <T> void putFavorite(Class<T> type, T value) {
		favorites.put(Objects.requireNonNull(type), type.cast(value));
		//favorites.put(type, value);
	}
	
	public <T> T getFavorite (Class<T> type) {
		return  type.cast(favorites.get(type));
	}

}
