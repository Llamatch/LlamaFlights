import os
import re
import glob
import urllib2
from bs4 import BeautifulSoup

def find_planeImg(reg):
   #br = mechanize.Browser()
   #br.set_handle_refresh(mechanize._http.HTTPRefreshProcessor(), max_time=1)
   #br.addheaders = [('User-agent', 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:35.0) Gecko/20100101 Firefox/35.0')]
   #r = br.open('http://www.planespotters.net/')
   #br.select_form(nr=1)
   #br.form['tag'] = reg
   #br.submit()
   search = 'http://www.planespotters.net/search.php?q='+reg
   req = urllib2.Request(search, headers={ 'User-Agent': 'Mozilla/5.0' })
   soup = BeautifulSoup(urllib2.urlopen(req).read())
   #soup = BeautifulSoup(br.response().read())
   found = False
   for link in soup.find_all('a'):
       href = link.get('href')
       if href is not None:
          if len(re.findall('^\/Aviation_Photos\/photo[.]show.+', href)) >= 1:
             found = True
             break
   if not found:
      return None
   url = 'http://www.planespotters.net'+href
   req = urllib2.Request(url, headers={ 'User-Agent': 'Mozilla/5.0' })
   #br.open(url)
   #soup = BeautifulSoup(br.response().read())
   soup = BeautifulSoup(urllib2.urlopen(req).read())
   for img in soup.find_all('img'):
       src = img.get('src')
       if len(re.findall('^http:\/\/img[.].+', src)) >= 1:
          break
   return src

