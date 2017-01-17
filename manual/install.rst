.. _installation:

============
Installation
============


Pre-built Binaries
==================

.. note::

    This is the recommended way of installing for normal users.

Pre-built binaries are available from `Maven Central <https://search.maven.org>`_.
Download sidmrom-cli-\ |version| \.jar from `here <http://search.maven.org/#search%7Cga%7C1%7Csimdrom>`_.


.. _install_from_source:

Install from Source
===================

.. note::

    You only need to install from source if you want to develop SIMdrom in Java yourself.

There are two options of installing SIMdrom.
The recommended way for most users is to download a prebuilt binary and is well-described in the :ref:`quickstart` section.
This section describes how to build SIMdrom from scratch.

Prequisites
-----------

For building SIMdrom, you will need

#. `Java JDK 8 or higher <http://www.oracle.com/technetwork/java/javase/downloads/index.html>`_ for compiling Jannovar,
#. `Maven 3 <http://maven.apache.org/>`_ for building Jannovar, and
#. `Git <http://git-scm.com/>`_ for getting the sources.

Git Checkout
------------

In this tutorial, we will download the SIMdrom sources and build them in ``~/Development/SIMdrom``.

.. code-block:: console

   ~ # mkdir -p ~/SIMdrom
   ~ # cd ~/SIMdrom
   SIMdrom # git clone https://github.com/visze/simdrom.git simdrom
   SIMdrom # cd simdrom

Maven Proxy Settings
--------------------

If you are behind a proxy, you will get problems with Maven downloading dependencies.
If you run into problems, make sure to also delete ``~/.m2/repository``.
Then, execute the following commands to fill ``~/.m2/settings.xml``.

.. code-block:: console

    simdrom # mkdir -p ~/.m2
    simdrom # test -f ~/.m2/settings.xml || cat >~/.m2/settings.xml <<END
    <settings>
      <proxies>
       <proxy>
          <active>true</active>
          <protocol>http</protocol>
          <host>proxy.example.com</host>
          <port>8080</port>
          <nonProxyHosts>*.example.com</nonProxyHosts>
        </proxy>
      </proxies>
    </settings>
    END

Building
--------

You can build SIMdrom using ``mvn package``.
This will automatically download all dependencies, build SIMdrom, and run all tests.

.. code-block:: console

    simdrom # mvn package

In case that you have non-compiling test, you can use the `-DskipTests=true` parameter for skipping them.

.. code-block:: console

    simdrom # mvn install -DskipTests=true

Creating Eclipse Projects
-------------------------

Maven can be used to generate Eclipse projects that can be imported by the Eclipse IDE.
This can be done calling ``mvn eclipse:eclipse`` command after calling ``mvn install``:

.. code-block:: console

    simdrom # mvn install
    simdrom # mvn eclipse:eclipse
