package dds.tp.carbono.http.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Route {
    public String path;
    public String absolute;
    public Uri uri;
    public Route parent;
    public Route[] children;

    public Route(Uri uri, String path, Route... children) {
        this.path = path;
        this.children = children;
        this.uri = uri;

        Arrays.stream(this.children).forEach(c -> c.parent = this);
    }

    public Map<Uri, String> branches() {
        Map<Uri, String> branches = new TreeMap<>();
        absolute = (parent == null) ? path : parent.absolute + path;
        branches.put(uri, absolute);
        Arrays.stream(children).forEach(c -> branches.putAll(c.branches()));

        return branches;
    }
}
