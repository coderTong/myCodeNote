

```

➜  ~ certbot --nginx --nginx-server-root=/application/nginx/conf -d www.itopengl.com
Saving debug log to /var/log/letsencrypt/letsencrypt.log
NGINX configured with OpenSSL alternatives is not officially supported by Certbot.
Plugins selected: Authenticator nginx, Installer nginx
Starting new HTTPS connection (1): acme-v02.api.letsencrypt.org
Cert is due for renewal, auto-renewing...
Renewing an existing certificate for www.itopengl.com
Performing the following challenges:
http-01 challenge for www.itopengl.com
Waiting for verification...
Cleaning up challenges
Deploying Certificate to VirtualHost /application/nginx/conf/nginx.conf
Traffic on port 80 already redirecting to ssl in /application/nginx/conf/nginx.conf

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Your existing certificate has been successfully renewed, and the new certificate
has been installed.

The new certificate covers the following domains: https://www.itopengl.com
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

IMPORTANT NOTES:
 - Congratulations! Your certificate and chain have been saved at:
   /etc/letsencrypt/live/www.itopengl.com/fullchain.pem
   Your key file has been saved at:
   /etc/letsencrypt/live/www.itopengl.com/privkey.pem
   Your certificate will expire on 2021-09-13. To obtain a new or
   tweaked version of this certificate in the future, simply run
   certbot again with the "certonly" option. To non-interactively
   renew *all* of your certificates, run "certbot renew"
 - If you like Certbot, please consider supporting our work by:

   Donating to ISRG / Let's Encrypt:   https://letsencrypt.org/donate
   Donating to EFF:                    https://eff.org/donate-le


```
