import {manifest, version} from '@parcel/service-worker';

async function install() {
    const cache = await caches.open(version);
    await cache.addAll(manifest);
}
addEventListener('install', e => e.waitUntil(install()));

async function activate() {
    const keys = await caches.keys();
    await Promise.all(
        keys.map(key => key !== version && caches.delete(key))
    );
}
addEventListener('activate', e => e.waitUntil(activate()));


self.addEventListener('fetch', function (event) {
    event.respondWith(
        caches.match(event.request)
            .then(function(response){
                if (response){
                    return response;
                } else {
                    return fetch(event.request)
                        .then(function (res) {
                            return caches.open(version)
                                .then(function (cache) {
                                    cache.put(event.request.url, res.clone());
                                    return res;
                                })
                        });
                }
            })
    );
});